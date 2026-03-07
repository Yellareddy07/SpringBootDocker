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

        stage('Docker Build') {
            steps {
                sh 'docker build -t springboot-app .'
            }
        }

        stage('Start MySQL') {
            steps {
                sh '''
                    docker run -d \
                      --name mysql \
                      -e MYSQL_ROOT_PASSWORD=root \
                      -e MYSQL_DATABASE=SpringDocker \
                      -p 3306:3306 \
                      mysql:8 || true
                '''
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    # Stop and remove old container
                    docker stop springboot-app-container || true
                    docker rm springboot-app-container || true

                    # Run new container
                    docker run -d \
                      --name springboot-app-container \
                      -p 8080:8080 \
                      --link mysql:mysql \
                      -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/SpringDocker \
                      -e SPRING_DATASOURCE_USERNAME=root \
                      -e SPRING_DATASOURCE_PASSWORD=Suyochi@123 \
                      springboot-app
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
