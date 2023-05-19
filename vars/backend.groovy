def call (){
                      sh """
                            docker login -u $USERNAME -p $PASSWORD
                            docker build -t monasamir/server:c${BUILD_NUMBER} $WORKSPACE/badreads-backend/ 
                            docker push monasamir/server:c${BUILD_NUMBER} 
                       """
}
