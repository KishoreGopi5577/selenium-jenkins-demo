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

                            try {
                                bat 'mvn test -Dbrowser=chrome'
                            } finally {
                                junit 'target/surefire-reports/TEST-*.xml'
                            }
                        }
                    }
                }

                stage('Firefox') {
                    steps {
                        ws("${env.WORKSPACE}@firefox") {
                            checkout scm

                            try {
                                bat 'mvn test -Dbrowser=firefox'
                            } finally {
                                junit 'target/surefire-reports/TEST-*.xml'
                            }
                        }
                    }
                }

                stage('Edge') {
                    steps {
                        ws("${env.WORKSPACE}@edge") {
                            checkout scm

                            try {
                                bat 'mvn test -Dbrowser=edge'
                            } finally {
                                junit 'target/surefire-reports/TEST-*.xml'
                            }
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