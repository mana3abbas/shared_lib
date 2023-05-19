def call(){
                sh 'cd HELM'  
                sh 'pwd'
                sh """
                         echo "Running Helm"
                         helm install vois${BUILD_NUMBER} ./HELM/onboard-task
                   """   
}
