/*
 * Copyright Txus Ballesteros 2018 (@txusballesteros)
 *
 * This file is part of some open source application.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * Contact: Txus Ballesteros <txus.ballesteros@gmail.com>
 */
package com.txusballesteros.codelabs.billboard.feature.moviedetail.di

import com.txusballesteros.codelabs.billboard.feature.moviedetail.data.MovieCloudDataSource
import com.txusballesteros.codelabs.billboard.feature.moviedetail.data.MovieDataSource
import com.txusballesteros.codelabs.billboard.feature.moviedetail.domain.repository.MovieRepository
import com.txusballesteros.codelabs.billboard.feature.moviedetail.domain.usecase.GetMovieByIdUseCase
import com.txusballesteros.codelabs.billboard.feature.moviedetail.presentation.MovieBackdropPresenter
import com.txusballesteros.codelabs.billboard.feature.moviedetail.presentation.MovieDetailComposerPresenter
import com.txusballesteros.codelabs.billboard.feature.moviedetail.presentation.MoviePosterPresenter
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

internal val featureModule = Kodein.Module(name = "MovieDetailFeatureModule") {
    bind<MovieDataSource>() with provider { MovieCloudDataSource(instance()) }
    bind<MovieRepository>() with  singleton { MovieRepository(instance()) }
    bind<GetMovieByIdUseCase>() with provider { GetMovieByIdUseCase(instance()) }
    bind<MovieDetailComposerPresenter>() with provider { MovieDetailComposerPresenter(instance()) }
    bind<MovieBackdropPresenter>() with provider { MovieBackdropPresenter() }
    bind<MoviePosterPresenter>() with provider { MoviePosterPresenter() }
}
