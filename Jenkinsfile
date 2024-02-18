pipeline {
    agent any
    
    
    tools {
        maven 'Maven'
    }

    
    stages {
        stage('Clonar Repositorio') {
            steps {
               git branch: 'main', url: 'https://github.com/W3irdev/calculatorSpring.git'
            }
        }
        
        stage('Construir Aplicación') {
            steps {
                 
                    sh 'mvn clean package -DskipTests=true'
                 
            }
        }

    }
}
