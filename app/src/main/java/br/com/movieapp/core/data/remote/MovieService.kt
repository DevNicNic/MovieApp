package br.com.movieapp.core.data.remote

import br.com.movieapp.core.data.remote.response.MovieDetailResponse
import  retrofit2.http.Query
import br.com.movieapp.core.data.remote.response.MovieResponse
import br.com.movieapp.core.data.remote.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    @GET("movie/popular") // faz um requisição HTTP para obter dados nesse caso os filmes populares da API
    suspend fun getPopularMovie(  //essa função aassíncrona permite que a execução do  programa não seja interrompida enquanto espera pelas respostas das requisições
        @Query("page") page: Int // para especificar o número da página na lista de resultados
    ): MovieResponse

    @GET("search/multi")
    suspend fun searchMovie(
        @Query("page") page: Int,
        @Query("query") query: String //definir o termo de pesquisa na busca por filmes
    ): SearchResponse

    @GET("movie/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") movieId: Int // para substituir o ID do filme na URL ao buscar detalhes de um filme específico.
    ): MovieDetailResponse

    @GET("movie/{movie_id}/similar")
    suspend fun getMoviesSimilar(
        @Path("movie_id") movieId: Int,
        @Query("page") page: Int
    ): MovieResponse

}
