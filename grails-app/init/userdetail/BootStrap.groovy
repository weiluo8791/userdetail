package userdetail

import findMeSitter.user.*


class BootStrap {

    def init = { servletContext ->
        environments {
            development {

            }
            test {

            }
            production {
                //do nothing
            }
        }
    }



    def destroy = {
    }

}