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

            val employee = Employee(inID, inName, inAddress)
            emp.add(employee)
        }

        fun remove() {

        }

        fun edit() {

        }

        fun getEmployees(): MutableList<Employee> = emp
    }
}

fun main(args: Array<String>) {
    val names: List<String> = listOf("Jamet", "Memet", "Rahmat")

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