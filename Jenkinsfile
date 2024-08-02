pipeline{
    agent any

   environment{
        DOCKER_TOKEN= credentials('my-ghcr-token')
        DOCKER_USER = 'johnskouloudis'
        GHCR_URL= 'ghcr.io/johnskouloudis/assignment_rid_v1'

   }

    stages{
        stage('Checkout'){
            steps{
                git branch: 'main', url: 'https://github.com/JohnSkouloudis/Assignment_RID_v1.git'
            }
        }

        stage('Build'){
            steps{
                sh 'docker build -t assignment_rid_v1:latest .'

            }
        }

        stage('Push'){
            steps{

                sh "echo ${DOCKER_TOKEN} | docker login ghcr.io -u ${DOCKER_USER} --password-stdin"
                sh "docker tag assignment_rid_v1:1.0  ${GHCR_URL}:latest"
                sh "docker push ${GHCR_URL}:latest"
            }
        }

        stage('Deploy'){
            steps{
                withCredentials([usernamePassword(credentialsId: 'my-db-creds', usernameVariable: 'DB_USERNAME', passwordVariable: 'DB_PASSWORD')]) {
                        
                        sh 'docker compose up -d'
                    }
            }
        }

        
    }         

}
