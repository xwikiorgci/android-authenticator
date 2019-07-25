package org.xwiki.android.sync.contactdb.dao_repositories

import org.xwiki.android.sync.contactdb.UserAccount
import org.xwiki.android.sync.contactdb.UserAccountId
import org.xwiki.android.sync.contactdb.abstracts.UserAccountsRepository
import org.xwiki.android.sync.contactdb.dao.AccountsDao

class DAOUserAccountsRepository (
    private val accountsDao: AccountsDao
) : UserAccountsRepository {
    override suspend fun createAccount(userAccount: UserAccount) {
        accountsDao.insertAccount(userAccount)
    }

    override suspend fun findByAccountName(name: String): UserAccount? = accountsDao.findByAccountName(name)
    override suspend fun findByAccountId(id: UserAccountId): UserAccount? = accountsDao.findById(id)

    override suspend fun updateAccount(userAccount: UserAccount) {
        accountsDao.updateUser(userAccount)
    }

    override suspend fun deleteAccount(userAccountName: String) {
        accountsDao.deleteUser(userAccountName)
    }
}