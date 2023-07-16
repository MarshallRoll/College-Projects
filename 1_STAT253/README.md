# STAT_253_Project

In this project, we use statistical machine learning techniques in R to predict health outcomes related to strokes. 

## Regression
Regression Dataset: https://www.kaggle.com/datasets/andrewmvd/heart-failure-clinical-data

We centered our research around the question: Which of the available biological factors are most accurate in predicting platelet levels, which are related to stroke events? Using OLS, LASSO, and GAM modeling techniques, we created several models to predict platelet levels for patients, compared their accuracy and interpretability, finding that, although all models are relatively weak, the LASSO is the most useful due to its ease of interpretation.

## Classification 
Classification Dataset: https://www.kaggle.com/datasets/fedesoriano/stroke-prediction-dataset

We centered our research in the classification setting around predicting whether an individual is likely to have a stroke based on certain biological and social predictors. To achieve this, we created models using the frameworks of logistic LASSO, decision trees, and random forests. We find that the logistic LASSO is a stronger model because it is more interpretable and gives clearer metrics of variable importance and that biological women, age, hypertension, working a government job, and unemployment are the strongest predictors of stroke events.

## Clustering
Clustering Dataset: https://www.kaggle.com/datasets/fedesoriano/stroke-prediction-dataset

Using hierarchical clustering with complete linkage, we created 6 clusters and cut at a height of ~12.5 to uncover underlying patterns in the dataset that might shed light on the likelihood of patients to have a stroke event. We find that clusters with higher average glucose levels tend to have higher instances of stroke, whereas BMI does not tend to be as important in the dataset.