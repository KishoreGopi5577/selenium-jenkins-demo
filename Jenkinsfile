pipeline {

    agent any

    stages {

        stage('Parallel Browser Tests') {

            parallel {

                stage('Chrome') {
                    steps {
                        bat 'mvn clean test -Dbrowser=chrome'
                    }
                }

                stage('Firefox') {
                    steps {
                        bat 'mvn clean test -Dbrowser=firefox'
                    }
                }

                stage('Edge') {
                    steps {
                        bat 'mvn clean test -Dbrowser=edge'
                    }
                }
            }
        }
    }
}