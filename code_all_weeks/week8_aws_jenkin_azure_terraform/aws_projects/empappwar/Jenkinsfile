pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "localmvn"
    }
    stages {
        stage('Build') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/rgupta00/empappwar.git']])
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/empapp.war'
                }
            }
        }


    stage ('Deploy to tomcat server') {
             steps{
                 deploy adapters: [tomcat9(credentialsId: 'tomcat_server', path: '', url: 'http://localhost:8080/')], contextPath: '/empapp', war: '**/*.war'
             }
         }
    }
}
