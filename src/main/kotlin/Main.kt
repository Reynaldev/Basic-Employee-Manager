data class Employee(val id: Int, var name: String, var address: String)

class EmployeeManager() {
    companion object Factory {
        var emp: MutableList<Employee> = mutableListOf()

        fun add() {
            print("ID: ")
            val inID: Int = readlnOrNull()?.toInt() ?: 0

            print("Name: ")
            val inName: String = readlnOrNull().toString()

            print("Address: ")
            val inAddress: String = readlnOrNull().toString()

            if (inID == 0) {
                println("ID should be more than 0 or not empty")
                return
            }

            if (inName.isBlank() || inName.isEmpty()) {
                println("Name should be filled")
                return
            }

            if (inAddress.isBlank() || inAddress.isEmpty()) {
                println("Address should be filled")
                return
            }

            val employee = Employee(inID, inName, inAddress)
            emp.add(employee)
        }

        fun remove() {
            print("ID: ")
            val inID: Int = readlnOrNull()?.toInt() ?: 0

            if (inID == 0) {
                println("ID should be more than 0 or not empty")
                return
            }

            val employee: Employee? = emp.find { e -> e.id == inID }

            emp.remove(employee)
        }

        fun edit() {
            print("ID: ")
            val inID: Int = readlnOrNull()?.toInt() ?: 0

            if (inID == 0) {
                println("ID should be more than 0 or not empty")
                return
            }

            var employee: Employee? = emp.find { e -> e.id == inID }

            print("Name: ")
            var inName: String = readlnOrNull().toString()

            print("Address: ")
            var inAddress: String = readlnOrNull().toString()

            if (inName.isBlank()) {
                inName = employee?.name.toString()
            }

            if (inAddress.isBlank()) {
                inAddress = employee?.address.toString()
            }

            employee?.name = inName
            employee?.address = inAddress
        }

        fun getEmployees(): MutableList<Employee> = emp
    }
}

fun main(args: Array<String>) {
    println("ThisCompany")

    while (true) {
        println("Employees")

        println("| ID | Name | Address |")
        for (e in EmployeeManager.getEmployees()) {
            println("| ${e.id} | ${e.name} | ${e.address} |")
        }

        println("1) Add\n" +
                "2) Remove\n" +
                "3) Edit\n")
        print(">> ")
        val input: Int = readlnOrNull()?.toInt() ?: 0

        when (input) {
            1 -> EmployeeManager.add()
            2 -> EmployeeManager.remove()
            3 -> EmployeeManager.edit()
            else -> println("Invalid command")
        }
    }
}