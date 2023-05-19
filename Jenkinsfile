@Library('shared-lib') _
pipeline {
    agent { label 'jenkins-slave' }
    stages {
        stage('build') {
            steps {
                script {
                   withCredentials([usernamePassword(credentialsId: 'dockerhubaccount', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) 
                    {
                        backend ()
                        frontend ()
                   }
                }
            }
        }
        stage('deploy') {
          
            steps {
                  withCredentials([file(credentialsId: 'kubeconfig-credi', variable: 'KUBECONFIG')]) 
                {
               helm ()
                }
                  }
            }
    }
}
