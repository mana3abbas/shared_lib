def call (){
    sh """
                            docker login -u $USERNAME -p $PASSWORD
                            docker build -t monasamir/client:c${BUILD_NUMBER} -f $WORKSPACE/badreads-frontend/Dockerfile  
                            docker push monasamir/client:c${BUILD_NUMBER}
                          """
}