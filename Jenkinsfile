pipeline {
    agent any
    triggers {
        pollSCM 'H/2 * * * *'
    }
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Build Docker image') { 
            steps {
                sh 'docker build -t liiketaloudellisia-algoritmeja .'
            }
        }
        stage('Deliver docker image') {
            steps {
                sh 'echo todo'
            }
        }
    }
}