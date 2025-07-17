CODE_CHANGES = true
pipeline {
    agent any
    stages {
        stage('build') {
            when {
                expression {
                    BRANCH_NAME == 'master' && CODE_CHANGES == true
                }
            }
            steps {
                echo 'building the application...'
            }
        }
        stage('test') {
            when {
                expression {
                    BRANCH_NAME == 'development'
                }
            }
            steps {
                echo 'testing the application...'
            }
        }
        stage('deploy') {
            steps {
                echo 'deploying the application...'
            }
        }
    }
}
