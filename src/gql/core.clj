(ns gql.core
  (:require [instaparse.core :as insta]
            [clojure.java.io :as io]))

(def graphql
  (-> (io/resource "grammar.bnf")
    (insta/parser :auto-whitespace :standard)))

(defn mapify
  [t]
  (insta/transform
    {:fields vector
     :params hash-map
     :query  (comp (partial zipmap [:name :params :fields]) vector)}
    t))

(defn parse
  [s]
  (-> s
    graphql
    mapify))
