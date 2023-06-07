def call (name){
                     sh """
                          docker login -u $USERNAME -p $PASSWORD
                            docker build -t monasamir/${name}:c${BUILD_NUMBER} $WORKSPACE/badreads-frontend/
                            docker push monasamir/${name}:c${BUILD_NUMBER}
                          """
}
