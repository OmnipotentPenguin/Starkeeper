pipeline {
    agent any
    options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
    }
    stages {
        stage('---clean---') {
            steps {
                sh "mvn clean"
            }
        }
        stage('--package--') {
            steps {
                sh "mvn package"
                sh "docker build -t omnipotentpenguin/starkeeper-dev ."
            }
        }
        stage('--deploy--') {
            steps {
                sh "mvn deploy"
            }
        }
        stage('--publishToDocker--') {
            steps {
                withDockerRegistry([ credentialsId: "dockerhub-adam", url: "" ]){
                    sh "docker push omnipotentpenguin/starkeeper-dev:latest"
                }
            }
        }        
    }
}
