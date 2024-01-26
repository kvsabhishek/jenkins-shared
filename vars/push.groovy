def push(String component){

    echo "Pushing image to docker hub of component : $component"

    pipeline{

        agent any
        stages{
            stage("pushing to docker hub"){
                script{
                    withCredentials([usernamePassword(credentialsId: 'docker-auth', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                        sh """
                            docker login -u $USERNAME -p $PASSWORD
                            docker push joindevops/${component}:${packageVersion}
                        """
                    }
                }
            }
        }
    }
}