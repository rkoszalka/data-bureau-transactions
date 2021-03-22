pipeline {
    agent {
        label 'java11'
    }

    tools {
        jdk 'java11'
    }

    environment {
        gradle = "./gradlew --no-daemon"
        tag = "1.0.0"
        SERVICE_NAME = "bureau-activities"
    }

    stages {
        stage("Clean") {
            steps {
                sh "${gradle} clean"
            }
        }

        stage("Build and Unit Test Cassandra") {
            steps {
                sh "cd bureau-cassandra"
                sh "${gradle} build -x test"
                sh "${gradle} test"
                sh "mkdir build/docker"
                sh "cp conf/* build/docker"
            }
        }

        stage("Deploy Cassandra") {
            steps {
                script {
                    // sh to deploy cassandra
                }
            }
        }

        stage("Build and Unit Test  Ml Access") {
            steps {
                sh "cd bureau-ml-access"
                sh "${gradle} build -x test"
                sh "${gradle} test"
                sh "mkdir build/docker"
                sh "cp conf/* build/docker"
            }
        }

        stage("Deploy Ml Access") {
            steps {
                script {
                    // sh to deploy ml access
                }
            }
        }

        stage("Build and Unit Test  PII Access") {
            steps {
                sh "cd bureau-pii-access"
                sh "${gradle} build -x test"
                sh "${gradle} test"
                sh "mkdir build/docker"
                sh "cp conf/* build/docker"
            }
        }

        stage("Deploy PII Access") {
            steps {
                script {
                    // sh to deploy pii access
                }
            }
        }

// If I find the time to implement SonarQube and Jacoco I will uncomment the following lines

//        stage("SonarQube") {
//             steps {
//                 sh "cd bureau-cassandra"
//                 sh "${gradle} test"
//             }
//         }


//         stage('Publish Tests') {
//             steps {
//                 junit '**/build/reports/jacoco/test/jacocoTestReport.xml'
//                 archive 'build/*.jar'
//                 step([$class: 'JacocoPublisher', execPattern: '**/build/jacoco/unit-test.exec'])
//             }
//         }

//         stage("Integration Tests") {
//             steps {
//                 sh "${gradle} integrationTest"
//             }
//         }

}

post {
        always {
            deleteDir()
        }

        success {
            sh echo "Release Job: ${env.JOB_NAME} - Build: ${env.BUILD_NUMBER} : Successful Delivery!"
        }

        failure {
            sh echo "Release Job: ${env.JOB_NAME} - Build: ${env.BUILD_NUMBER} : Delivery Error!"
        }
    }
}
