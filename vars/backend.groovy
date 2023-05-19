def call (){
                    sh """
                            docker login -u $USERNAME -p $PASSWORD
                            docker build -t monasamir/server:b${BUILD_NUMBER} -f $WORKSPACE/badreads-backend/Dockerfile  
                            docker push monasamir/server:b${BUILD_NUMBER} 
                       """
}