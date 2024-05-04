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
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo "Testing.."
                mvn 'test'
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
