@Library('shared-lib') _
pipeline {
    agent { label 'jenkins-slave' }
      parameters {
         choice(name: 'build', choices: [dev,test,prod], description: 'choose a value')
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
                  script {
                    withCredentials([file(credentialsId: 'kubeconfig-credi', variable: 'KUBECONFIG')])
                            { 
                             if (params.DEPLOY == 'dev')
                                {
                                  sh 'cd HELM'  
                                  sh 'pwd'
                                  sh """
                                    echo "Running Helm"
                                   helm install dev${BUILD_NUMBER} ./HELM/onboard-task --values ./HELM/onboard-task/dev.yaml
                                    """
                               }
                          else if (params.DEPLOY == 'test')
                                {
                                  sh 'cd HELM'  
                                  sh 'pwd'
                                  sh """
                                    echo "Running Helm"
                                   helm install test${BUILD_NUMBER} ./HELM/onboard-task --values ./HELM/onboard-task/test.yaml
                                    """
                               }
                         else if (params.DEPLOY == 'prod')
                                {
                                  sh 'cd HELM'  
                                  sh 'pwd'
                                  sh """
                                    echo "Running Helm"
                                   helm install prod${BUILD_NUMBER} ./HELM/onboard-task --values ./HELM/onboard-task/prod.yaml
                                    """
                               }
                    }
                }
            }
        }
    }  
}
