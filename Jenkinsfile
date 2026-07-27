pipeline {
    agent any

    tools {
        jdk 'Java21'
        maven 'maven3'
    }

    environment {
        EC2_HOST = "54.224.170.179"
        EC2_USER = "ubuntu"

        SSH = '"C:\\Program Files\\Git\\usr\\bin\\ssh.exe"'
        SCP = '"C:\\Program Files\\Git\\usr\\bin\\scp.exe"'

        PEM_FILE = "C:\\Users\\MAMATHA K\\Downloads\\green-basket-key.pem"
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
                bat """
                %SCP% -i "%PEM_FILE%" -o StrictHostKeyChecking=no target\\green-basket-retail-1.0.0.war %EC2_USER%@%EC2_HOST%:/home/ubuntu/
                """
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                bat """
                %SSH% -i "%PEM_FILE%" -o StrictHostKeyChecking=no %EC2_USER%@%EC2_HOST% "/home/ubuntu/deploy.sh"
                """
            }
        }
    }

    post {
        success {
            echo "===================================="
            echo "Deployment Successful!"
            echo "===================================="
        }

        failure {
            echo "===================================="
            echo "Deployment Failed!"
            echo "===================================="
        }
    }
}