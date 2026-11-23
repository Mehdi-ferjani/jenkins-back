pipeline {
    agent any

    tools {
        jdk 'JAVA_HOME'
        maven 'M2_HOME'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Tests unitaires') {
            steps {
                sh 'mvn clean test'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Livrable') {
            steps {
                sh 'mvn package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
    }

    post {
        failure {
            mail to: 'ferjanimehdi02@gmail.com',
                 subject: "Build échoué : ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Le build a échoué.\nVoir les détails : ${env.BUILD_URL}console"
        }
    }
}
