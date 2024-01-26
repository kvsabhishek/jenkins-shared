def build( String component ) {

    echo "Compenent to build : $component"

    pipeline {
        agent any
        
        stages{
            stage("build"){
                sh "docker build . -t abhishek0897/$component"
            }
        }
    }
}