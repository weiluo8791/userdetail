package userdetail

import findMeSitter.user.*


class BootStrap {

    def init = { servletContext ->
        environments {
            development {
                setupUsersAndRoles()
            }
            test {
                setupUsersAndRoles()
            }
            production {
                //do nothing
            }
        }
    }

    def saveObject(object) {
        if (!object.save(flush:true)) {
            object.errors.allErrors.each { println it }
        }
    }

    def setupUsersAndRoles(){
        User admin = new User (username: 'admin',password: 'supersecret')
        saveObject(admin)

        User user1 = new User (username: 'ithomas',password: 'ithomas')
        saveObject(user1)
        User user2= new User (username: 'ljames',password: 'ljames')
        saveObject(user2)
        User user3= new User (username: 'jwall',password: 'jwall')
        saveObject(user3)

        Role adminRole = new Role(authority: Role.ROLE_ADMIN)
        saveObject(adminRole)
        Role userRole = new Role(authority: Role.ROLE_USER)
        saveObject(userRole)

        UserRole.create(admin,adminRole)
        UserRole.create(admin,userRole)
        UserRole.create(user1,userRole)
        UserRole.create(user2,userRole)
        UserRole.create(user3,userRole)
    }

    def destroy = {
    }

}