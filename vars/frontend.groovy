def call(name){
                     sh """
                          docker login -u $USERNAME -p $PASSWORD
                            docker build -t monasamir/client:c${BUILD_NUMBER} $WORKSPACE/badreads-frontend/
                            docker push monasamir/client:c${BUILD_NUMBER}
                          """
}
