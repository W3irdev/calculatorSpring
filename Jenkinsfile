pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE = 'tomcat:latest'
        APP_NAME = 'calculadora'
    }
    
    stages {
        stage('Clonar Repositorio') {
            steps {
               git branch: 'main', url: 'https://github.com/W3irdev/calculatorSpring.git'
            }
        }
        
        
        stage('Construir Imagen Docker') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE}")
                }
            }
        }
        
        stage('Desplegar en Tomcat') {
            steps {
                script {
                    docker.image("${DOCKER_IMAGE}").push('latest')
                }
                sh 'docker run -d --name ${APP_NAME} -p 8080:8080 ${DOCKER_IMAGE}'
            }
        }

    }
}
