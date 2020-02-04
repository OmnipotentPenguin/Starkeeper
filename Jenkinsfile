pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                sh "mvn clean"
            }
        }
        stage('--test--') {
            steps {
                sh "mvn test"
            }
        }
        stage('--package--') {
            steps {
                sh "mvn package"
nexusPublisher nexusInstanceId: 'repository', nexusRepositoryId: 'pipeline-repository-hosted', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: 'Starkeeper', extension: '.jar', filePath: '(StarKeeper)/target/Starkeeper.jar']], mavenCoordinate: [artifactId: 'Starkeeper', groupId: 'com.bae.starkeeper', packaging: 'jar', version: '0.0.1-SNAPSHOT']]]
            }
        }
    }
}
