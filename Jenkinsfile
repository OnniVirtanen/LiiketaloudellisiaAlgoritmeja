pipeline {
    agent { 
        node {
            label 'jenkins-agent-v1'
            }
      }
      triggers {
        pollSCM '*/5 * * * *'
      }
    stages {
        stage('Build') {
            steps {
                echo "Building.."
                sh 'mvn package'
            }
        }
        stage('Test') {
            steps {
                echo "Testing.."
                sh 'mvn test'
            }
        }
        stage('Deliver') {
            steps {
                echo 'Deliver....'
                sh '''
                echo "doing delivery stuff.."
                '''
            }
        }
    }
}
