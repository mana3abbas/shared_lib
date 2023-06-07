@Library('shared-lib') _
pipeline {
    agent { label 'jenkins-slave' }
     parameters {
          choice choices: ['dev', 'test', 'prod'], description: 'pick one ', name: 'DEPLOY'
     }
    stages {
        stage('build') {
            steps {
                script {
                   withCredentials([usernamePassword(credentialsId: 'dockerhubaccount', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) 
                    {
                        frontend(client,frontend)
                        frontend (server,backend)
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
