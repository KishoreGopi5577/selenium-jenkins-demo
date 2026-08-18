pipeline {

    agent any

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean compile test-compile'
            }
        }

        stage('Parallel Browser Tests') {

            parallel {

                stage('Chrome') {
                    steps {
                        ws("${env.WORKSPACE}@chrome") {
                            checkout scm
                            bat 'mvn test -Dbrowser=chrome'
                        }
                    }

                    post {
                        always {
                            junit 'target/surefire-reports/TEST-*.xml'
                        }
                    }
                }

                stage('Firefox') {
                    steps {
                        ws("${env.WORKSPACE}@firefox") {
                            checkout scm
                            bat 'mvn test -Dbrowser=firefox'
                        }
                    }

                    post {
                        always {
                            junit 'target/surefire-reports/TEST-*.xml'
                        }
                    }
                }

                stage('Edge') {
                    steps {
                        ws("${env.WORKSPACE}@edge") {
                            checkout scm
                            bat 'mvn test -Dbrowser=edge'
                        }
                    }

                    post {
                        always {
                            junit 'target/surefire-reports/TEST-*.xml'
                        }
                    }
                }
            }
        }
    }

    post {

        always {
            echo 'Pipeline execution completed.'
        }

        success {
            echo 'All browser tests passed.'
        }

        failure {
            echo 'One or more browser tests failed.'
        }
    }
}