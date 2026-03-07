pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Yellareddy07/SpringBootDocker.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        //when you dont have yml file
        /*
        stage('Docker Build') {
            steps {
                sh 'docker build -t springboot-app .'
            }
        }

        stage('Setup Network') {
            steps {
                sh 'docker network create springboot-network || true'
            }
        }

        stage('Start MySQL') {
            steps {
                sh '''
                    # Remove old mysql container if exists
                    docker stop mysql || true
                    docker rm mysql || true

                    # Start fresh MySQL container
                    docker run -d \
                      --name mysql \
                      --network springboot-network \
                      -e MYSQL_ROOT_PASSWORD=Suyochi@123 \
                      -e MYSQL_DATABASE=SpringDocker \
                      -v mysql-data:/var/lib/mysql \
                      mysql:8

                    # Wait for MySQL to be ready
                    sleep 20
                '''
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    # Stop and remove old app container
                    docker stop springboot-app-container || true
                    docker rm springboot-app-container || true

                    # Run new container on same network
                    docker run -d \
                      --name springboot-app-container \
                      --network springboot-network \
                      -p 8081:8080 \
                      -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/SpringDocker \
                      -e SPRING_DATASOURCE_USERNAME=root \
                      -e SPRING_DATASOURCE_PASSWORD=Suyochi@123 \
                      springboot-app
                '''
            }
        }
        */
        //when you have yml file
        stage("Deploy"){
            steps{
                sh'''
                docker-compose down
                docker-compose up -d --build
                '''
            }
        }
    }
    


    post {
        success {
            echo 'Application deployed successfully!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
