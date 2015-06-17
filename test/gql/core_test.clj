(ns gql.core-test
  (:require [clojure.test :refer :all]
            [gql.core :refer :all]
            [clojure.java.io :as io]
            [instaparse.core :as insta]))

(deftest parse-graphql-query
  (let [query (slurp (io/resource "query.gql"))]
    (is (empty? (insta/get-failure (graphql query))))))
