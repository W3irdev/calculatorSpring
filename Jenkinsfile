pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage("clone code"){
            steps{
                git branch: 'main', url: 'https://github.com/W3irdev/calculatorSpring.git'
            }
        }
        stage("build code"){
            steps{
                sh "mvn clean install"
            }
        }        
    }
}
