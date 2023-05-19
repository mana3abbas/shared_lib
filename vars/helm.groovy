def call(){
                 if (params.DEPLOY == 'dev')
                                {
                                 
                                  sh """
                                    echo "Running Helm"
                                   helm install dev${BUILD_NUMBER} ./HELM/onboard-task --values ./HELM/onboard-task/dev.yaml
                                    """
                               }
                          else if (params.DEPLOY == 'test')
                          {
                                sh """
                                    echo "Running Helm"
                                   helm install dev${BUILD_NUMBER} ./HELM/onboard-task --values ./HELM/onboard-task/test.yaml
                                    """
                               }
                         else if (params.DEPLOY == 'prod')
                                {
                              
                                  sh """
                                    echo "Running Helm"
                                   helm install prod${BUILD_NUMBER} ./HELM/onboard-task --values ./HELM/onboard-task/prod.yaml
                                    """
                               }
}
