pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile test-compile'
            }
        }

        stage('Parallel Browser Tests') {

            parallel {

                stage('Chrome') {
                    steps {
                        bat 'mvn test -Dbrowser=chrome'
                    }
                }

                stage('Firefox') {
                    steps {
                        bat 'mvn test -Dbrowser=firefox'
                    }
                }

                stage('Edge') {
                    steps {
                        bat 'mvn test -Dbrowser=edge'
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