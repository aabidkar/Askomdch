pipeline {
    agent any
stages{
    stage("Build"){
        steps{
            echo("Build the Project.")
        }
    }
        stage("Deploy to Dev"){
        steps{
            echo("Deploying to Dev Env.")
        }
    }
            stage("Deploy to QA"){
        steps{
            echo("Deploying to QA Env.")
        }
            }
        stage("Regression automation test cases."){
         steps{
            echo("Run Regression test cases.")
        }
}
        stage("Deploy to Stage"){
         steps{
            echo("Deploying to Stage Env.")
        }
}
        stage("Sanity automation test cases."){
         steps{
            echo("Run Sanity test cases.")
        }
}
        stage("Deploy to UAT"){
         steps{
            echo("Deploying to UAT Env.")
        }
}
}
}