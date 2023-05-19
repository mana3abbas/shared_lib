@Library('shared-lib') _
pipeline {
    agent { label 'jenkins-slave' }
       }
    stages {
        stage('build') {
            steps {
                script {
                   withCredentials([usernamePassword(credentialsId: 'dockerhubaccount', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) 
                    {
                       backend ()
                   
                       sh """
                            docker login -u $USERNAME -p $PASSWORD
                            docker build -t monasamir/client:v${BUILD_NUMBER} -f $WORKSPACE/badreads-frontend/Dockerfile  
                            docker push monasamir/client:b${BUILD_NUMBER}
                          """
                   }
                }
            }
        }
         stage('deploy') {
          
            steps {
                  withCredentials([file(credentialsId: 'kubeconfig-credi', variable: 'KUBECONFIG')]) 
                {
                sh 'cd HELM'  
                sh 'pwd'
                sh """
                         echo "Running Helm"
                         helm install vois${BUILD_NUMBER} ./HELM/onboard-task
                        """  
                }
                  }
            }
    }
}
