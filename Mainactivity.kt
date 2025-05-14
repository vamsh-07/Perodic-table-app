class MainActivity : AppCompatActivity() {
    private lateinit var birthdayDao: BirthdayDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        birthdayDao = AppDatabase.getDatabase(this).birthdayDao()

        val recyclerView = findViewById<RecyclerView>(R.id.birthdayRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = BirthdayAdapter()
        recyclerView.adapter = adapter

        birthdayDao.getAll().observe(this) { list ->
            adapter.submitList(list)
        }

        findViewById<Button>(R.id.addBirthdayButton).setOnClickListener {
            startActivity(Intent(this, AddBirthdayActivity::class.java))
        }
    }
}
