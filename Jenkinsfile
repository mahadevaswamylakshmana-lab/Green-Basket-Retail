pipeline {
    agent any

    tools {
        jdk 'Java21'
        maven 'maven3'
    }

    environment {
        EC2_HOST = "54.224.170.179"
        EC2_USER = "ubuntu"
        REMOTE_WAR = "/home/ubuntu/green-basket-retail-1.0.0.war"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Archive WAR') {
            steps {
                archiveArtifacts artifacts: 'target/*.war', fingerprint: true
            }
        }

        stage('Copy WAR to EC2') {
            steps {
                sshagent(credentials: ['ec2-key']) {
                    bat '''
                    scp -o StrictHostKeyChecking=no target\\green-basket-retail-1.0.0.war %EC2_USER%@%EC2_HOST%:%REMOTE_WAR%
                    '''
                }
            }
        }

        stage('Deploy on EC2') {
            steps {
                sshagent(credentials: ['ec2-key']) {
                    bat '''
                    ssh -o StrictHostKeyChecking=no %EC2_USER%@%EC2_HOST% "/home/ubuntu/deploy.sh"
                    '''
                }
            }
        }
    }

    post {
        success {
            echo '======================================'
            echo 'Deployment completed successfully!'
            echo '======================================'
        }

        failure {
            echo '======================================'
            echo 'Deployment failed!'
            echo '======================================'
        }
    }
}