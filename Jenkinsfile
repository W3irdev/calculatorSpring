pipeline {
    agent any
    
    
    tools {
        maven 'Maven'
    }

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
        
        stage('Construir Aplicación') {
            steps {
                 dir('/var/lib/jenkins/workspace/Automatizacion del trabajo calculatorSpring Josemi') {
                    sh 'mvn clean package'
                 }
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
