def call (name,fname){
                     sh """
                          docker login -u $USERNAME -p $PASSWORD
                            docker build -t monasamir/${name}:c${BUILD_NUMBER} $WORKSPACE/badreads-${fname}/
                            docker push monasamir/${name}:c${BUILD_NUMBER}
                          """
}
