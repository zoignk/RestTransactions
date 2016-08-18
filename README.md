# RestTransactions
Basic Banking Transactions Rest service example

There are 4 Restful procedures. Each one produces response in JSON format.

1) getTransactionById - returns TransactionBean with specified transaction_id
2) getTransactionsByType - returns array of transaction_id-s for TransactionBeans with specified type
3) getSumByParentId - returns sum of amounts for transactions with specified parent_id
4) putTransactionInMap - adds new TransactionBean to global in memory map.

Also there is basic test-case for getTransactionById service.

Maven-archetype jersey-quickstart-grizzly2 is used for initial project structure.

