class AddBirthdayActivity : AppCompatActivity() {
    private lateinit var birthdayDao: BirthdayDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_birthday)

        birthdayDao = AppDatabase.getDatabase(this).birthdayDao()

        val name = findViewById<EditText>(R.id.nameInput)
        val phone = findViewById<EditText>(R.id.phoneInput)
        val date = findViewById<EditText>(R.id.dateInput)
        val message = findViewById<EditText>(R.id.messageInput)

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            val birthday = Birthday(
                name = name.text.toString(),
                phone = phone.text.toString(),
                date = date.text.toString(),
                message = message.text.toString()
            )

            Thread {
                birthdayDao.insert(birthday)
                finish()
            }.start()
        }
    }
}
