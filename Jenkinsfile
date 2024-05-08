pipeline {
    agent { 
        node {
            label 'ec2-cloud'
            }
      }
      triggers {
        pollSCM 'H/2 * * * *'
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
