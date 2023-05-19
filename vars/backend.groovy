def call (){
                    sh """
                            docker login -u $USERNAME -p $PASSWORD
                            docker build -t monasamir/server:c${BUILD_NUMBER} -f $WORKSPACE/badreads-backend/Dockerfile  
                            docker push monasamir/server:c${BUILD_NUMBER} 
                       """
}
