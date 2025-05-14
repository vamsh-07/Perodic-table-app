@Dao
interface BirthdayDao {
    @Insert fun insert(birthday: Birthday)
    @Query("SELECT * FROM birthdays ORDER BY date") fun getAll(): LiveData<List<Birthday>>
}
